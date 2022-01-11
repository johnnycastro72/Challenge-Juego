const optionResolver = {
    Query: {
        getAllOptions: async(_, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.getAllOptions()
            else
                return null
        }

    },
    
    Mutation: {
        createOption: async(_, { option }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null) {
                const optionInput = {
                    answer: option.answer,
                    correct: option.correct,
                }
                return await dataSources.qaGameAPI.createOption(optionInput)
            }
            else
                return null
            }
    }
};

module.exports = optionResolver; 