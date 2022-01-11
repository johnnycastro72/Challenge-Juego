const categoryResolver = {
    Query: {
        getAllCategories: async(_, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.getAllCategories()
            else
                return null
        }

    },
    Mutation: {
        createCategory: async(_, { category }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null) {
                const categoryInput = {
                    level: category.level,
                }
                return await dataSources.qaGameAPI.createCategory(categoryInput)
            }
            else
                return null
            }
    }
};

module.exports = categoryResolver; 