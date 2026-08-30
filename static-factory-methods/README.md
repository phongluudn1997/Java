5 Advantages of Static Factory Methods:

1. They have names - Express intent clearly (e.g. Color.fromRGB(), Color.fromHEX())
2. No new object required everytime - Enables caching/flyweight patterns (e.g. Boolean.valueOf())
3. Can return any subtype - Hide implementation classes behind interfaces/abstract classes (e.g. PaymentGateway)
4. Return type varies by input - Dynamically chooses optimal subtype based on parameters (e.g. ImageCompressor)
5. Class need not exist when written - Enables plug-and-play architecture & Service Provider Framework (e.g. JDBC, DriverManager)
