import React, { useEffect, useState } from "react";
import { restaurantsAPI } from "../api";
import RestaurantForm from "./RestaurantForm";

export default function RestaurantList() {
  const [items, setItems] = useState([]);
  const [editing, setEditing] = useState(null);
  const [error, setError] = useState("");

  async function load() {
    try {
      const data = await restaurantsAPI.list();
      setItems(data || []);
    } catch (e) {
      setError(e.message);
    }
  }

  useEffect(() => { load(); }, []);

  async function handleDelete(id) {
    if (!confirm("Delete restaurant?")) return;
    try {
      await restaurantsAPI.remove(id);
      setItems((s) => s.filter((r) => r.id !== id));
    } catch (e) {
      setError(e.message);
    }
  }

  async function handleSave(payload) {
    try {
      if (payload.id) {
        const updated = await restaurantsAPI.update(payload.id, payload);
        setItems((s) => s.map((r) => (r.id === updated.id ? updated : r)));
      } else {
        const created = await restaurantsAPI.create(payload);
        setItems((s) => [created, ...s]);
      }
      setEditing(null);
    } catch (e) {
      setError(e.message);
    }
  }

  return (
    <div>
      {error && <div className="error">{error}</div>}
      <button onClick={() => setEditing({})}>Create restaurant</button>
      {editing && <RestaurantForm item={editing} onCancel={() => setEditing(null)} onSave={handleSave} />}
      <ul className="list">
        {items.map((r) => (
          <li key={r.id}>
            <div className="row">
              <div>
                <strong>{r.name}</strong> — {r.phone} — Price: {r.priceRange} — Active: {String(r.active)}
              </div>
              <div>
                <button onClick={() => setEditing(r)}>Edit</button>
                <button onClick={() => handleDelete(r.id)}>Delete</button>
              </div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}