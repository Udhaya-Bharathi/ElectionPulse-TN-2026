import api from "../api/api";

export const getAllRegions = async () => {
    const response = await api.get("/regions");
    return response.data;
};