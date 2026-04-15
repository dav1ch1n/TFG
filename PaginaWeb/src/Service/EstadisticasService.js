import api from './api';

// Función para obtener todos los personajes
export const EstadisticasService = async () => {
    try {
        // Como en api.js ya pusimos la ruta base, aquí solo ponemos el final
        const respuesta = await api.get('/estadisticas');
        return respuesta.data;
    } catch (error) {
        console.error("Error en el service de personajes:", error);
        throw error; // Lanzamos el error para que la página sepa que falló
    }
};
