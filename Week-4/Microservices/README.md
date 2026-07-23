# Account, Loan, and Discovery Service

Start order: discovery server, account service, then loan service. Use ports
8761, 8081, and 8082 respectively. The API gateway should route `/accounts/**`
and `/loans/**` to the two application services.
