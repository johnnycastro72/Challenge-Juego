const { gql } = require('apollo-server');

const categoryTypeDefs = gql `
    type Category {
        id: String!
        level: String!
    }

    input CategoryInput {
        level: String!
    }

    extend type Query {
        getAllCategories(): [Category]
    }

    extend type Mutation {
        createCategory(category: CategoryInput!): Category
    }
`;

module.exports = categoryTypeDefs;