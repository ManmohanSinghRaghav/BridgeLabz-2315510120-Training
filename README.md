# Bridge Lab Classes

## Constructor Best Practices Implemented

### 1. Use of `this` Keyword
- Avoid ambiguity when parameter names match attribute names
- Example: `this.customerName = customerName;`

### 2. Constructor Chaining
- Default constructors call parameterized constructors
- Reduces code duplication and ensures consistent initialization

### 3. Validation and Encapsulation
- Private validation methods keep constructors clean
- Input validation prevents invalid object states
- Encapsulated business logic in private methods

### 4. Multiple Constructor Types
- Default constructors for convenience
- Parameterized constructors for custom initialization
- Copy constructors for object cloning

## Access Modifier Best Practices Implemented

### 1. Least Privilege Principle
- Start with private and relax as needed
- Attributes are private with public getters/setters

### 2. Proper Encapsulation
- Private attributes with controlled access
- Validation in setter methods
- Protected members for inheritance scenarios

### 3. Inheritance Considerations
- Protected members accessible in subclasses
- Public methods for external interface
- Private implementation details hidden

## Advanced Programming Best Practices

### 1. Static Keyword Usage
- **Static Variables**: Shared data across all instances
  - Example: `bankName`, `libraryName`, `companyName`
- **Static Methods**: Utility methods that don't need instance data
  - Example: `getTotalAccounts()`, `displayTotalEmployees()`
- **Memory Efficiency**: Reduces memory usage by sharing common data

### 2. This Keyword Usage
- **Ambiguity Resolution**: Clear distinction between parameters and fields
  - Example: `this.name = name;`
- **Method Chaining**: Enables fluent interfaces
- **Clarity**: Makes code more readable and explicit

### 3. Final Keyword Usage
- **Constants**: Immutable values that cannot be changed
  - Example: `final String accountNumber`, `final int rollNumber`
- **Security**: Prevents accidental modification of critical identifiers
- **Design Intent**: Clearly indicates which values should remain constant

### 4. Instanceof Keyword Usage
- **Type Safety**: Safe type checking before casting
  - Example: `if (obj instanceof BankAccount)`
- **Runtime Safety**: Prevents ClassCastException
- **Polymorphism Support**: Enables safe handling of different object types

## Object Modeling and Relationships

### 1. Association Relationship
- **Definition**: Objects are related but can exist independently
- **Implementation**: Objects hold references to each other
- **Examples**:
  - Student ↔ Course (many-to-many association)
  - Customer ↔ BankAccount (one-to-many association)
  - Doctor ↔ Patient (many-to-many association)

### 2. Aggregation Relationship (Has-A)
- **Definition**: Container object contains other objects, but contained objects can exist independently
- **Implementation**: Container holds collection of objects
- **Examples**:
  - Library → Book (library has books, books can exist without library)
  - School → Student (school has students, students can transfer schools)
  - University → Faculty (university has faculty, faculty can work elsewhere)

### 3. Composition Relationship (Part-Of)
- **Definition**: Strong ownership where child objects cannot exist without parent
- **Implementation**: Parent creates and manages child objects
- **Examples**:
  - Company → Department → Employee (employees belong to department, department belongs to company)
  - House → Room (rooms are part of house, cannot exist independently)
  - Car → Engine (engine is part of car)

### 4. Object Communication
- **Method Calls**: Objects communicate through method invocations
- **Data Sharing**: Objects share data through parameters and return values
- **Event Handling**: Objects respond to events from other objects
- **Examples**:
  - `student.enrollInCourse(course)` - Student communicates with Course
  - `library.borrowBook(title)` - Library communicates with Book
  - `account.transferMoney(toAccount, amount)` - Account communicates with another Account

## Classes Demonstrating Best Practices

### Constructor Examples
- `BookWithConstructors` - Multiple constructors with chaining
- `PersonWithCopyConstructor` - Copy constructor and validation
- `HotelBooking` - Constructor chaining and business logic
- `CarRental` - Complex initialization with calculations
- `CircleWithChaining` - Constructor chaining pattern

### Access Modifier Examples
- `StudentAccessModifiers` - Public, protected, private usage
- `BookLibrary` - Inheritance with access modifiers
- `BankAccountAccess` - Encapsulation and controlled access
- `EmployeeAccess` - Proper access control with inheritance

### Static Concept Examples
- `Product` - Class variables and methods
- `Course` - Shared state management
- `Vehicle` - Static variable modification

### Advanced Programming Practice Examples
- `BankAccount` - All four concepts (static, this, final, instanceof)
- `LibraryManagementSystem` - Book class with comprehensive practices
- `EmployeeManagementSystem` - Employee management with best practices
- `ShoppingCartSystem` - Product class with discount management
- `UniversityStudentManagement` - Student data with grade operations

### Object Modeling Examples
- `LibraryManagement` - Aggregation (Library → Book)
- `BankCustomerSystem` - Association (Customer ↔ BankAccount)
- `CompanyManagement` - Composition (Company → Department → Employee)
- `Student` with `Course` - Association (Student ↔ Course)

## Key Patterns Used

1. **Constructor Chaining**: Default → Parameterized
2. **Validation Methods**: Private helper methods
3. **Encapsulation**: Private attributes, public interface
4. **Inheritance**: Protected members for subclass access
5. **Static Management**: Class-level state and behavior
6. **Type Safety**: instanceof checks before operations
7. **Immutable Identifiers**: final variables for unique IDs
8. **Shared Resources**: static variables for common data
9. **Object Communication**: Methods for inter-object interaction
10. **Relationship Modeling**: Association, Aggregation, Composition

## Programming Principles Demonstrated

- **DRY (Don't Repeat Yourself)**: Static methods reduce code duplication
- **Single Responsibility**: Each method has a clear purpose
- **Encapsulation**: Private data with controlled access
- **Type Safety**: Runtime type checking with instanceof
- **Immutability**: final variables for unchangeable data
- **Resource Management**: Static variables for shared resources
- **Loose Coupling**: Objects interact through well-defined interfaces
- **High Cohesion**: Related functionality grouped together
- **Object Relationships**: Proper modeling of real-world relationships
- **Communication Patterns**: Clear interaction between objects
