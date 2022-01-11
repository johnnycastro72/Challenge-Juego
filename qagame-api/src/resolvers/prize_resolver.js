const prizeResolver = {
    Query: {
        getAllPrizes: async(_, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.getAllPrizes()
            else
                return null
        }

    },
    
    Mutation: {
        createPrize: async(_, { prize }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null) {
                const prizeInfo = {
                    prize: prize.prize,
                    value: prize.value,
                }
                return await dataSources.qaGameAPI.createPrize(prizeInfo)
            }
            else
                return null
            }
    }
};

module.exports = prizeResolver; 