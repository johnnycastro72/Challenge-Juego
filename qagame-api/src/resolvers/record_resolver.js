const recordResolver = {
    Query: {
        getAllRecords: async(_, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.getAllRecords()
            else
                return null
        },

        findByidStatus: async(_, { status }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null)
                return await dataSources.qaGameAPI.findByidStatus(status)
            else
                return null
        }

    },
    Mutation: {
        createRecord: async(_, { record }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaAuthAPI.getUser(userIdToken)).username
            if (usernameToken != null) {
                const recordInfo = {
                    user = record.user,
                    date = record.date,
                    idRound = record.idRound,
                    idQuestion = record.idQuestion,
                    idStatus = record.idStatus,
                }
                return dataSources.qaGameAPI.createRecord(recordInfo)
            }
            else
                return null
            },

    },

};

module.exports = recordResolver; 