const statusResolver = {
    Query: {
        getAllStatus: async(_, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.getAllStatus()
            else
                return null
        }

    },
    
    Mutation: {
        createStatus: async(_, { status }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null) {
                const statusInput = {
                    status: status.status,
                }
                return await dataSources.qaGameAPI.createStatus(statusInput)
            }
            else
                return null
            }
    }
};

module.exports = statusResolver; 