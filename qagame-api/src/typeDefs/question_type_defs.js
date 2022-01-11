const { gql } = require('apollo-server');

const questionTypeDefs = gql `
    type Category {
        id: String!
        level: String!
    }

    type Option {
        id: String!
        answer: String!
        correct: Boolean!
    }

    type Question {
        id: String!
        idCategory: Category!
        squestion: String!
        options: [Option]!
    }

    input CategoryInput {
        level: String!
    }

    input OptionInput {
        answer: String!
        correct: Boolean!
    }
    input QuestionInput {
        idCategory: CategoryInput!
        squestion: String!
        options: [OptionInput]!
    }

    extend type Query {
        getAllQuestions: [Question]
        findByidCategory(category: String!): [Question]
    }

    extend type Mutation {
        createQuestion(question: QuestionInput!): Question
        updateQuestion(id: String!, question: QuestionInput!): Question
        deleteQuestion(id: String!): ID
    }
    
`;

module.exports = questionTypeDefs;