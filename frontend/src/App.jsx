import React from "react";
import RestaurantList from "./components/RestaurantList";

export default function App() {
  return (
    <div className="container">
      <h1>Delivery Admin — Restaurants</h1>
      <RestaurantList />
    </div>
  );
}