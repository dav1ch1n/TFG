import api from './api';

// Función para obtener todos los personajes
export const ObjetosService = async () => {
    try {
        // Como en api.js ya pusimos la ruta base, aquí solo ponemos el final
        const respuesta = await api.get('/objetos');
        return respuesta.data;
    } catch (error) {
        console.error("Error en el service de objetos:", error);
        throw error; // Lanzamos el error para que la página sepa que falló
    }
};
