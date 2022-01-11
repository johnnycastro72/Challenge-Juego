const { gql } = require('apollo-server');

const recordTypeDefs = gql `
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
        srecord: String!
        options: [Option]!
    }

    type Status {
        id: String!
        status: String!
    }

    type Record {
        id: String!
        user: String!
        date: String!
        idRound: Round!
        idQuestion: Question!
        idStatus: Status!
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
        srecord: String!
        options: [OptionInput]!
    }

    input StatusInput {
        status: String!
    }
    input RecordInput {
        user: String!
        date: String!
        idRound: RoundInput!
        idQuestion: QuestionInput!
        idStatus: StatusInput!
    }

    extend type Query {
        getAllRecords: [Record]
        findByidStatus(status: String!): [Record]
    }

    extend type Mutation {
        createRecord(record: RecordInput!): Record
    }
    
`;

module.exports = recordTypeDefs;