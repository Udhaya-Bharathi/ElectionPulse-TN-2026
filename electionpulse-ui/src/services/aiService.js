import api from "../api/api";

export const analyzeDistrict = async (district) => {

    const response = await api.post("/ai/analyze", {
        question: district
    });

    return response.data;
};