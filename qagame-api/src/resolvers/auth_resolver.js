const usersResolver = {
    Query: {
        userDetailById: (_, { userId }, { dataSources, userIdToken }) => {
            if (userId == userIdToken)
                return dataSources.qaauthAPI.getUser(userId)
            else
                return null
        },
    },
    Mutation: {
        signUpUser: async(_, { userInput }, { dataSources }) => {
            const authInput = {
                username: userInput.username,
                password: userInput.password,
                name: userInput.name,
                email: userInput.email,
            }
            return await dataSources.qaAuthAPI.createUser(authInput);
        },

        logIn: (_, { credentials }, { dataSources }) =>
            dataSources.qaAuthAPI.authRequest(credentials),

        refreshToken: (_, { refresh }, { dataSources }) =>
            dataSources.qaAuthAPI.refreshToken(refresh),
    }
};
module.exports = usersResolver;