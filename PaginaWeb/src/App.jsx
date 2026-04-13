import { useEffect, useState } from 'react'
import axios from 'axios'
import './App.css'

function App() {
  // Aquí guardaremos los personajes que vengan de Java
  const [personajes, setPersonajes] = useState([])

  // Este useEffect se ejecuta una sola vez al cargar la página
  useEffect(() => {
    // Asegúrate de que tu Spring Boot está arrancado antes de hacer esto
    axios.get('http://localhost:8080/api/personajes')
      .then(respuesta => {
        console.log("Datos recibidos:", respuesta.data);
        setPersonajes(respuesta.data);
      })
      .catch(error => {
        console.error("Error al conectar con la API:", error);
      })
  }, [])

  return (
    <div>
      <h1>Wiki Megabonk</h1>
      <h2>Lista de Personajes:</h2>

      <div className="card-container">
        {personajes.length === 0 ? (
          <p>Cargando personajes o no hay datos...</p>
        ) : (
          personajes.map((personaje) => (
            <div key={personaje.idPersonajes} className="card">
              <h3>{personaje.nombre}</h3>
              <p><strong>Arma:</strong> {personaje.nombreArma}</p>
              <p><strong>Habilidad:</strong> {personaje.habilidad}</p>
            </div>
          ))
        )}
      </div>
    </div>
  )
}

export default App