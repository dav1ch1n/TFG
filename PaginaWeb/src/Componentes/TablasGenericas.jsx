import React from 'react';
import './TablasGenericas.css';

function TablasGenericas({ titulo, datos, carpetaImg, campoSubtitulo, onInfoClick }) {
  return (
    <div className="tablas-container">
      <header className="tablas-header">
        <h2 className="tablas-titulo">{titulo}</h2>
        <a href="/" className="tablas-volver">⬅ Volver</a>
      </header>

      <div className="tablas-lista">
        {datos.map((item, index) => (
          <div key={item.id || index} className="tablas-fila">
            {/* Imagen */}
            <div className="tablas-img-col">
              <img
                src={`/src/img/${carpetaImg}/${item.nombre}.png`}
                alt={item.nombre}
                className="tablas-img"
                onError={(e) => {
                  e.target.onerror = null;
                  e.target.src = '/src/assets/hero.png';
                }}
              />
            </div>

            {/* Info */}
            <div className="tablas-info-col">
              <strong className="tablas-nombre">{item.nombre}</strong>
              <span className="tablas-subtitulo">{item[campoSubtitulo]}</span>
            </div>

            {/* Botón */}
            <div className="tablas-btn-col">
              <button className="tablas-btn" onClick={() => onInfoClick(item)}>
                + Info
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default TablasGenericas;
