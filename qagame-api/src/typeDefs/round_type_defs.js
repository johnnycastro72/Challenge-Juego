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

    input CategoryInput {
        level: String!
    }

    input PrizeInput {
        prize: String!
        value: Int!
    }
    input RoundInput {
        idCategory: CategoryInput!
        idPrize: PrizeInput!
    }

    extend type Query {
        getAllRounds: [Round]
        findByideCategory(category: String!): [Round]
    }

    extend type Mutation {
        createRound(round: RoundInput!): Round
    }
`;

module.exports = roundTypeDefs;