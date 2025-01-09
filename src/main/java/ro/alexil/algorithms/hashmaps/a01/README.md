# Logger Rate Limiter

## Problem Statement

You are tasked with solving the **Logger Rate Limiter** problem.

Given a stream of message requests along with their timestamps, you must implement a logger rate limiter system. This system will decide whether the current message request should be displayed based on whether the same message has been displayed in the last `S` seconds.

- If the same message has already been displayed within the last `S` seconds, the decision will be **FALSE** (duplicate message).
- Otherwise, the decision will be **TRUE** (unique message).

### Important Notes:
- Even though the timestamps for different requests may differ, they can still carry identical messages.

## Constraints
- `1 ≤ request.length ≤ 10^2`
- `0 ≤ timestamp ≤ 10^3`
- Timestamps are provided in **ascending order**.
- Messages consist of lowercase or uppercase English letters.

## Example
Consider the following example input of message requests:

| Message   | Timestamp |
| --------- | --------- |
| "foo"     | 1         |
| "bar"     | 2         |
| "foo"     | 3         |
| "bar"     | 8         |
| "foo"     | 10        |
| "foo"     | 11        |

The expected behavior of the logger rate limiter will be as follows:
1. At timestamp `1`, the message `"foo"` is displayed. (Decision: **TRUE**)
2. At timestamp `2`, the message `"bar"` is displayed. (Decision: **TRUE**)
3. At timestamp `3`, the message `"foo"` is ignored since it was already displayed less than `S` seconds ago. (Decision: **FALSE**)
4. At timestamp `8`, the message `"bar"` is displayed again since it was displayed more than `S` seconds ago. (Decision: **TRUE**)
5. At timestamp `10`, the message `"foo"` is displayed again. (Decision: **TRUE**)
6. At timestamp `11`, the message `"foo"` is ignored as it was just displayed at timestamp `10`. (Decision: **FALSE**)

## Approach

- A **hash map** (or dictionary) can be used to store the last timestamp when each message was displayed.
- For each new message, the logger will compare the current timestamp with the last timestamp stored for that message.
- If the difference is less than `S` seconds, the message is ignored (decision **FALSE**). Otherwise, it is displayed (decision **TRUE**), and the timestamp is updated.

## Complexity

- Time Complexity: `O(n)` where `n` is the number of message requests.
- Space Complexity: `O(m)` where `m` is the number of distinct messages.

---

## License
This project is licensed under the MIT License.
