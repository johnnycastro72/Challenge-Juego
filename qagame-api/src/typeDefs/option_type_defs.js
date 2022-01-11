const { gql } = require('apollo-server');

const optionTypeDefs = gql `
    type Option {
        id: String!
        answer: String!
        correct: Boolean!
    }

    input OptionInput {
        answer: String!
        correct: Boolean!
    }

    extend type Query {
        getAllOptions(): [Option]
    }

    extend type Mutation {
        createOption(option: OptionInput!): Option
    }
`;

module.exports = optionTypeDefs;