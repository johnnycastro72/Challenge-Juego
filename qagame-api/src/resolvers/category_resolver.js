const accountResolver = {
    Query: {
        getAllCategories: async(_, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.qaauthAPI.getUser(userIdToken)).username
            if (username == usernameToken)
                return await dataSources.accountAPI.accountByUsername(username)
            else
                return null
        },

        transactionByUsername: async(_, { username }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (username == usernameToken)
                return dataSources.accountAPI.transactionByUsername(username)
            else
                return null
        }
            
    },
    Mutation: {
        createTransaction: async(_, { transaction }, { dataSources, userIdToken }) => {
            usernameToken = (await dataSources.authAPI.getUser(userIdToken)).username
            if (transaction.usernameOrigin == usernameToken)
                return dataSources.accountAPI.createTransaction(transaction)
            else
                return null
            }
    }
};

module.exports = accountResolver; 