# gate-demo

Demo target for the Techtonik Impact Risk Gate.

One producer (`TokenResultDTO`) and six consumers that each read
`getExpiresIn()`. Deleting that field is a real compile break, so the gate
blocking the PR can be independently verified with `mvn compile`.

## Migration note

Callers that relied on the token TTL should refresh on 401 instead.
