import api from "../api/api";

export const getDistrictNames = async () => {

    const response = await api.get("/districts");

    return response.data;

};