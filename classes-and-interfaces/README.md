# Minimize mutability

Immutable class is a class whose instances cannot be modified.
Pros:

- Simplicity: An immutable object can be in exactly one state: the state in which it was created.
- Thread safety (Zero Synchronization Needed)
- Sharable internals: You can share not onle whole instances, but also their internal components.
- Great building blocks for other objects: Immutable objects make excellent keys for Map and elements for Set, as their invariants will never change while stored in collection.
- Failure Atomicity for free: An immutable object can never be left in an inconsistent intermediate state if an exception is thown.

Cons: Performance overhead for large objects
Solutions:

- Multistep operation package / companion classes: `String` is immutable, but `StringBuilder` is its public mutable companion used to assemble string efficienty.
- Caching frequently used instances: Use static factories to cache and reuse instances rather than intantiating new ones.

To make a class immutable, follow these rules:

1. Don't provide methods that modify the object's state.
2. Prevent subclassing.
3. Make all fields final.
4. Make all fiels private.
5. Ensure exclusive access to any mutable components: If the class has any fields that refer to mutable objects, ensure that the client of the class cannot object references to these objects.
