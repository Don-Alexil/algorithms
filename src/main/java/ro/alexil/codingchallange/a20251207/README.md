# Problem: Parsing a Boolean Expression

## Statement

You are given a string, expression, that represents a boolean expression. The expression can take one of the following forms:

- 't': Represents the boolean value TRUE.

- 'f': Represents the boolean value FALSE.

- '!(expr)': Represents a NOT operation applied to a subexpression expr. It returns the logical negation of expr.

- '&(expr1, expr2, ..., exprN)': Represents an *AND* operation over one or more subexpressions. It returns *TRUE* only if all subexpressions evaluate to *TRUE*.

- '|(expr1, expr2, ..., exprN)': Represents an *OR* operation over one or more subexpressions. It returns *TRUE* if at least one of the subexpressions evaluates to *TRUE*.

Your task is to parse this expression and return its boolean evaluation result.