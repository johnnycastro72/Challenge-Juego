const questionResolver = {
    Query: {
        getAllQuestions: async(_, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.getAllQuestions()
            else
                return null
        },
        
        findByidCategory: async(_, { category }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.findByidCategory(category)
            else
                return null
        }

    },

    Mutation: {
        createQuestion: async(_, { question }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null) {
                const questionInfo = {
                    idCategory: question.idCategory,
                    squestion: question.squestion,
                    options: question.options,
                }
                return await dataSources.qaGameAPI.createQuestion(questionInfo)
            }
            else
                return null
            },

        updateQuestion: async(_, { id, question }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null) {
                const questionInfo = {
                    idCategory: question.idCategory,
                    squestion: question.squestion,
                    options: question.options,
                }
                return await dataSources.qaGameAPI.updateQuestion(id, questionInfo)
            }
            else
                return null
            },

        deleteQuestion: async(_, { id }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.deleteQuestion(id)
            else
                return null
            }
    },

};

module.exports = questionResolver; 