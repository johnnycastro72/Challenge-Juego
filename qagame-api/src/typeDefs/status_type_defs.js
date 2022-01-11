const { gql } = require('apollo-server');

const statusTypeDefs = gql `
    type Status {
        id: String!
        status: String!
    }

    input StatusInput {
        status: String!
    }

    extend type Query {
        getAllStatus(): [Status]
    }

    extend type Mutation {
        createStatus(status: StatusInput!): Status
    }
`;

module.exports = statusTypeDefs;