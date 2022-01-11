const authResolver = require('./auth_resolver');
const categoryResolver = require('./category_resolver');
const optionResolver = require('./option_resolver');
const questionResolver = require('./question_resolver');
const prizeResolver = require('./prize_resolver');
const recordResolver = require('./record_resolver');
const roundResolver = require('./round_resolver');
const statusResolver = require('./status_resolver');

const lodash = require('lodash');

const resolvers = lodash.merge(authResolver, categoryResolver, optionResolver, prizeResolver, questionResolver, recordResolver, roundResolver, statusResolver);

module.exports = resolvers;