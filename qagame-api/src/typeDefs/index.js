const authTypeDefs     = require('./auth_type_defs');
const categoryTypeDefs = require('./category_type_defs');
const optionTypeDefs   = require('./option_type_defs');
const prizeTypeDefs    = require('./prize_type_defs');
const questionTypeDefs = require('./question_type_defs');
const recordTypeDefs   = require('./record_type_defs');
const roundTypeDefs    = require('./round_type_defs');
const statusTypeDefs   = require('./status_type_defs');
// Join schemas
const schemasArrays = [authTypeDefs, categoryTypeDefs, optionTypeDefs, prizeTypeDefs, questionTypeDefs, recordTypeDefs, roundTypeDefs, statusTypeDefs];
// export
module.exports = schemasArrays;