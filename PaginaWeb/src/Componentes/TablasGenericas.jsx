import React from 'react';

function TablasGenericas({ titulo, datos, carpetaImg, campoSubtitulo, onInfoClick }) {
  return (
    <div style={{ padding: '30px', color: 'white',width: '75%', maxWidth: '95%', margin: '0 auto' }}>
      <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '25px' }}>
        <h2 style={{ fontSize: '2rem' }}>{titulo}</h2>
        <a href="/" style={{ color: '#aaa', textDecoration: 'none', fontSize: '1.2rem' }}>⬅ Volver</a>
      </header>

      {/* TABLA PRINCIPAL (Ahora más grande) */}
      <div style={{ display: 'flex', flexDirection: 'column', gap: '15px' }}>
        {datos.map((item, index) => (
          <div key={item.id || index} style={{
            display: 'flex',
            backgroundColor: '#2c3e50',
            padding: '20px 25px', // Más relleno
            borderRadius: '10px',
            alignItems: 'center',
            fontSize: '2.1rem' // Letra más grande
          }}>
            {/* Columna 1: Imagen */}
            <div style={{ flex: '0.5' }}>
              <img
                src={`/src/img/${carpetaImg}/${item.nombre}.png`}
                alt={item.nombre}
                style={{ width: '100px', height: '100px', borderRadius: '8px', objectFit: 'cover', backgroundColor: '#1a252f' }}
                // EL ARREGLO DEL BUCLE: Si falla, pone null al error y carga el hero.png que ya tienes
                onError={(e) => {
                  e.target.onerror = null;
                  e.target.src = '/src/assets/hero.png';
                }}
              />
            </div>

            {/* Columna 2: Info Básica */}
            <div style={{ flex: '3', padding: '0 20px', }}>
              <strong style={{ fontSize: '35px', display: 'block', marginBottom: '5px' }}>{item.nombre}</strong>
              <span style={{ color: '#bdc3c7', fontSize: '30px' }}>{item[campoSubtitulo]}</span>
            </div>

            {/* Columna 3: Acción */}
            <div style={{ flex: '1', textAlign: 'right' }}>
              <button
                onClick={() => onInfoClick(item)}
                style={{ padding: '10px 20px', cursor: 'pointer', backgroundColor: '#e67e22', color: 'white', border: 'none', borderRadius: '6px', fontSize: '1rem', fontWeight: 'bold' }}>
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