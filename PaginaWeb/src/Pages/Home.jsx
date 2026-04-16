import React from 'react';
import { Link } from 'react-router-dom';
import '../Componentes/home.css';

function Home() {
  return (
    <div className="home-container">
      <h1 style={{ marginBottom: '40px' }}>WIKI MEGABONK</h1>
      <div className="menu-grid">
        <Link to="/personajes" className="menu-button">
          <span>👤</span>
          Personajes
        </Link>
        <Link to="/armas" className="menu-button">
          <span>⚔️</span>
          Armas
        </Link>
        <Link to="/tomos" className="menu-button">
          <span>📖</span>
          Tomos
        </Link>
        <Link to="/objetos" className="menu-button">
          <span>🎒</span>
          Objetos
        </Link>
      </div>
    </div>
  );
}

export default Home;