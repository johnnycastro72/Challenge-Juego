const { ApolloServer } = require('apollo-server');

const typeDefs = require('./typeDefs');
const resolvers = require('./resolvers');
const qaauthAPI = require('./dataSources/qaauth_api');
const qagameAPI = require('./dataSources/qagame_api');
const authentication = require('./utils/authentication');

const server = new ApolloServer({
    context: authentication, 
    typeDefs, 
    resolvers,
    dataSources: () => ({
        qaAuthAPI: new qaauthAPI(),
        qaGameAPI: new qagameAPI(),
    }),
    introspection: true,
    playground: true
});

server.listen(process.env.PORT || 4000).then(({ url }) => {
    console.log(`🚀 Server ready at ${url}`);
});
