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
                const optionInfo = {
                    answer = option.answer,
                    correct = option.correct,
                }
                return dataSources.qaGameAPI.createoption(optionInfo)
            }
            else
                return null
            }
    }
};

module.exports = optionResolver; 