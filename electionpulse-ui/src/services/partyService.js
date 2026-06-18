import api from "../api/api";

export const getAllParties = async () => {
    const response = await api.get("/parties");
    return response.data;
};