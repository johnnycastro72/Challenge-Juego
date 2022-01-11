const roundResolver = {
    Query: {
        getAllRounds: async(_, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.getAllRounds()
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
        createRound: async(_, { round }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null) {
                const roundInfo = {
                    idCategory = round.idCategory,
                    idPrize = round.idPrize,
                }
                return dataSources.qaGameAPI.createRound(roundInfo)
            }
            else
                return null
            },

    },

};

module.exports = roundResolver; 