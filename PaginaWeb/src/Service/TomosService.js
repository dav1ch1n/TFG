import api from './api';

// Función para obtener todos los personajes
export const TomosService = async () => {
    try {
        // Como en api.js ya pusimos la ruta base, aquí solo ponemos el final
        const respuesta = await api.get('/tomos');
        return respuesta.data;
    } catch (error) {
        console.error("Error en el service de tomos:", error);
        throw error; // Lanzamos el error para que la página sepa que falló
    }
};
