const BASE = "http://localhost:8080/api";

export async function fetchJSON(path, opts = {}) {
  const res = await fetch(BASE + path, {
    headers: { "Content-Type": "application/json" },
    ...opts,
  });
  if (!res.ok) throw new Error(await res.text());
  return res.status === 204 ? null : res.json();
}

export const restaurantsAPI = {
  list: () => fetchJSON("/restaurants"),
  get: (id) => fetchJSON(`/restaurants/${id}`),
  create: (body) =>
    fetchJSON("/restaurants", { method: "POST", body: JSON.stringify(body) }),
  update: (id, body) =>
    fetchJSON(`/restaurants/${id}`, { method: "PUT", body: JSON.stringify(body) }),
  remove: (id) => fetchJSON(`/restaurants/${id}`, { method: "DELETE" }),
};