const { RESTDataSource } = require('apollo-datasource-rest');

const serverConfig = require('../server');

class qaGameAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = serverConfig.qagame_api_url;
    }

    async createCategory(category) {
        category = new Object(JSON.parse(JSON.stringify(category)));
        return await this.post(`/categories`, category);
    }

    async getAllCategories() {
        return await this.get(`/categories`);
    }

    async getCategory(id) {
        return await this.get(`/categories/${id}`);
    }

    async updateCategory(id, category) {
        category = new Object(JSON.parse(JSON.stringify(category)));
        return await this.put(`/categories/${id}`, category);
    }

    async deleteCategory(id) {
        return await this.delete(`/categories/${id}`);
    }

    async deleteAllCategories() {
        return await this.delete(`/categories`);
    }

    async createOption(option) {
        option = new Object(JSON.parse(JSON.stringify(option)));
        return await this.post(`/options`, option);
    }

    async getAllOptions() {
        return await this.get(`/options`);
    }

    async getOption(id) {
        return await this.get(`/options/${id}`);
    }

    async updateOption(id, option) {
        option = new Object(JSON.parse(JSON.stringify(option)));
        return await this.put(`/options/${id}`, option);
    }

    async deleteOption(id) {
        return await this.delete(`/options/${id}`);
    }

    async deleteAllOptions() {
        return await this.delete(`/options`);
    }

    async createPrize(prize) {
        prize = new Object(JSON.parse(JSON.stringify(prize)));
        return await this.post(`/prizes`, prize);
    }

    async getAllPrizes() {
        return await this.get(`/prizes`);
    }

    async getPrize(id) {
        return await this.get(`/prizes/${id}`);
    }

    async updatePrize(id, prize) {
        prize = new Object(JSON.parse(JSON.stringify(prize)));
        return await this.put(`/prizes/${id}`, prize);
    }

    async deletePrize(id) {
        return await this.delete(`/prizes/${id}`);
    }

    async deleteAllPrizes() {
        return await this.delete(`/prizes`);
    }

    async createStatus(status) {
        status = new Object(JSON.parse(JSON.stringify(status)));
        return await this.post(`/status`, status);
    }

    async getAllStatus() {
        return await this.get(`/status`);
    }

    async getStatus(id) {
        return await this.get(`/status/${id}`);
    }

    async updateStatus(id, status) {
        status = new Object(JSON.parse(JSON.stringify(status)));
        return await this.put(`/status/${id}`, status);
    }

    async deleteStatus(id) {
        return await this.delete(`/status/${id}`);
    }

    async deleteAllStatus() {
        return await this.delete(`/status`);
    }

    async createRound(round) {
        round = new Object(JSON.parse(JSON.stringify(round)));
        return await this.post(`/rounds`, round);
    }

    async getAllRounds() {
        return await this.get(`/rounds`);
    }

    async getRound(id) {
        return await this.get(`/rounds/${id}`);
    }

    async findByidCategory(id) {
        return await this.get(`/rounds/category/${id}`);
    }

    async updateRound(id, round) {
        round = new Object(JSON.parse(JSON.stringify(round)));
        return await this.put(`/rounds/${id}`, round);
    }

    async deleteRound(id) {
        return await this.delete(`/rounds/${id}`);
    }

    async deleteAllRounds() {
        return await this.delete(`/rounds`);
    }

    async createQuestion(question) {
        question = new Object(JSON.parse(JSON.stringify(question)));
        return await this.post(`/questions`, prize);
    }

    async getAllQuestions() {
        return await this.get(`/questions`);
    }

    async getQuestion(id) {
        return await this.get(`/questions/${id}`);
    }

    async findByidCategory(id) {
        return await this.get(`/questions/category/${id}`);
    }

    async updateQuestion(id, question) {
        question = new Object(JSON.parse(JSON.stringify(question)));
        return await this.put(`/questions/${id}`, question);
    }

    async deleteQuestion(id) {
        return await this.delete(`/questions/${id}`);
    }

    async deleteAllQuestions() {
        return await this.delete(`/questions`);
    }

    async createRecord(record) {
        record = new Object(JSON.parse(JSON.stringify(record)));
        return await this.post(`/records`, record);
    }

    async getAllRecords() {
        return await this.get(`/records`);
    }

    async getRecord(id) {
        return await this.get(`/records/${id}`);
    }

    async findByidStatus(id) {
        return await this.get(`/records/status/${id}`);
    }

    async updateRecord(id, record) {
        record = new Object(JSON.parse(JSON.stringify(record)));
        return await this.put(`/records/${id}`, record);
    }

    async deleteRecord(id) {
        return await this.delete(`/records/${id}`);
    }

    async deleteAllRecords() {
        return await this.delete(`/records`);
    }

}

module.exports = qaGameAPI;
