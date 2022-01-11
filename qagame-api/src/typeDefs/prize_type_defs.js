const { gql } = require('apollo-server');

const prizeTypeDefs = gql `
    type Prize {
        id: String!
        prize: String!
        value: Int!
    }

    input PrizeInput {
        prize: String!
        value: Int!
    }

    extend type Query {
        getAllPrizes: [Prize]
    }

    extend type Mutation {
        createPrize(prize: PrizeInput!): Prize
    }
`;

module.exports = prizeTypeDefs;