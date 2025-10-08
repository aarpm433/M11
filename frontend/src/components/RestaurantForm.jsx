import React, { useEffect, useState } from "react";

export default function RestaurantForm({ item = {}, onSave, onCancel }) {
  const [form, setForm] = useState({
    id: item.id || null,
    name: item.name || "",
    phone: item.phone || "",
    email: item.email || "",
    priceRange: item.priceRange || 1,
    active: item.active === undefined ? true : item.active,
    user: item.user || null,
    address: item.address || null,
  });

  useEffect(() => setForm((f) => ({ ...f, id: item.id || null, name: item.name || f.name })), [item]);

  function change(e) {
    const { name, value, type, checked } = e.target;
    setForm((s) => ({ ...s, [name]: type === "checkbox" ? checked : (type === "number" ? Number(value) : value) }));
  }

  function submit(e) {
    e.preventDefault();
    // adapt: backend expects user/address ids or nested objects based on your API
    onSave(form);
  }

  return (
    <form className="card" onSubmit={submit}>
      <div>
        <label>Name</label>
        <input name="name" value={form.name} onChange={change} required />
      </div>
      <div>
        <label>Phone</label>
        <input name="phone" value={form.phone} onChange={change} required />
      </div>
      <div>
        <label>Email</label>
        <input name="email" value={form.email || ""} onChange={change} />
      </div>
      <div>
        <label>Price range</label>
        <input name="priceRange" type="number" min="1" max="3" value={form.priceRange} onChange={change} />
      </div>
      <div>
        <label>
          <input type="checkbox" name="active" checked={!!form.active} onChange={change} /> Active
        </label>
      </div>
      <div className="form-actions">
        <button type="submit">Save</button>
        <button type="button" onClick={onCancel}>Cancel</button>
      </div>
    </form>
  );
}