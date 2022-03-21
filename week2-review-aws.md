# AWS

### Cloud / AWS Overview
1. How would you describe AWS? What is "the cloud" or "cloud computing" and why is it so popular now? 
- AWS(Amazon Web Services) is cloud computing services that Amazon provides. Cloud computing is the 
on-demand delivery of compute power, database storage, applications and other IT resources through a cloud 
services platform and provides a simple way to access servers,databases, and storage. It's so popular now because
it's cost saving.
2. Define Infrastructure, Platform, and Software as a Service
- Infrastrcture as a Service is a self-service model for managing remote data center infrastructures. Users 
  will need to provide and manage application, data, runtime environment, operating system. 
- Platform as a Service allows organizations to build, run and manage applications without the IT infrastructure 
  and makes it easier and faster to develop, test and deploy applications.
- Software as a service replaces traditional on-device software with software that is licensed on a 
  subscription and is centrally hosted in the cloud.
 
3. What's the difference between a Region and an Availability Zone (AZ)?
- Regions are grouping of AWS zones in a geographical location with availability zones mapped to physical data 
  centers available worldwide.
- Availability zones are data centers containing an infrastructure
 
4. How are you charged for using AWS services? Does it vary by service?
- You are charged with a pay-as-you-go approach. You only pay for the AWS services you use.
  It does vary by service.
 
5. Different ways to interact with AWS services?
- Different ways to interact with AWS services include hosting a database on AWS and creating an eC2 virtual
  machine.


### EC2

1. What are the configuration options for EC2?
- AMI configuration to determine what kind of virtual machine you want(example: Amazon Linux 2 AMI). It acts as
  a template for your virtual machine. 
- Security groups configuration to control incoming and outgoing traffic based on IP address.
 
2. What are the different EC2 instance sizes/types?
- T2 micro, 
 
3. Once you create an EC2, how to connect to it?
- On the AWS Management Console, go to EC2 > Instances > and click on the configured instance. Click Connect > SSH Client.
  Then in the terminal run the ssh command: ssh -i [your-key-file] [your-ec2-instance-address]
 
4. What are Security Groups? When defining a rule for a security group, what 3 things do you need to specify?
- Security groups act as a virtual firewall for ec2 instances to control incoming and outgoing traffic based on IP address.
  You need to specify the port number, the protocol, and the source.
  
5. What's the difference between scalability, elasticity, and resiliency?
- Scalability is the ability to scale up as needed and pay for only what you use.
- Elasticity is the ability to instantly scale to meet spikes in demand or traffic.
- Resiliecy is the abilty to operate applications without interruption.
 
6. Ways of paying for EC2?
- You are able to have access to free tier t2.micro instances that allow 750 hours of use between all instances each month
  for one year. Then after that you'll have to pay by the second for instances.


### RDS

1. What's an RDS?
- An RDS is an Amazon Relational Database Service and is a web service that simplifies the set up of a relational database
  on the AWS cloud.

2. Which vendors are supported?
- Aurora, PostgresSQL, MySQL, MariaDB, Oracle, Microsoft SQL Server
