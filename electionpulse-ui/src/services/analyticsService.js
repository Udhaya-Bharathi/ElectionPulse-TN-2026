import api from "../api/api";

export const getDistrictPerformance = () => {
    return api.get("/analytics/district-performance");
};

export const getDistrictDetails = (districtName) => {
    return api.get(`/analytics/district/${districtName}`);
};



export const getAlliancePerformance = async () => {

    const response =
        await api.get("/analytics/alliance-performance");

    return response.data;

};

export const getPartyPerformance = async () => {

    const response =
        await api.get("/analytics/party-performance");

    return response.data;

};
export const getAllianceVoteShare = async () => {
    const response = await api.get("/analytics/alliance-vote-share");
    return response.data;
};

export const getPartyVoteShare = async () => {
    const response = await api.get("/analytics/party-vote-share");
    return response.data;
};