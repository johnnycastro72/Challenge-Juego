const { gql } = require('apollo-server');

const roundTypeDefs = gql `
    type Category {
        id: String!
        level: String!
    }

    type Prize {
        id: String!
        prize: String!
        value: Int!
    }

    type Round {
        id: String!
        idCategory: Category!
        idPrize: Prize!
    }

    input RoundInput {
        idCategory: Category!
        idPrize: Prize!
    }

    extend type Query {
        getAllRounds(): [Round]
        findByidCategory(category: String!) [Round]
    }

    extend type Mutation {
        createRound(round: RoundInput!): Round
    }
`;

module.exports = roundTypeDefs;