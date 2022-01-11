const { ApolloServer } = require('apollo-server');

const typeDefs = require('./typeDefs');
const resolvers = require('./resolvers');
const qaGameAPI = require('./dataSources/qagame_api');
const qaAuthAPI = require('./dataSources/qaauth_api');
const authentication = require('./utils/authentication');

const server = new ApolloServer({
    context: authentication,
        typeDefs,
        resolvers,
    dataSources: () => ({
        qaGameAPI: new qaGameAPI(),
        qaAuthAPI: new qaAuthAPI(),
    }),
    introspection: true,
    playground: true
});

server.listen(process.env.PORT || 4000).then(({ url }) => {
    console.log(`🚀 Server ready at ${url}`);
});
