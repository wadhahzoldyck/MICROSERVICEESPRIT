import { Eureka } from 'eureka-js-client';
const eurekaHost = (process.env.EUREKA_CLIENT_SERVICEURL_DEFAULTZONE)
export const registerWithEureka = (appName, PORT) => {
  const client = new Eureka({
    instance: {
      app: appName,
      hostName: 'commande-service', // Replace with your hostname
      port: {
        '$': PORT,
        '@enabled': true,
      },
      vipAddress: appName,
      dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn',
      },

    },
    eureka: {
      host: 'discovery-service', // Replace with your Eureka server host
      port: 8761, // Replace with your Eureka server port
      servicePath: '/eureka/apps/',
    },
  });

  client.logger.level('debug');

  client.start(error => {
    if (error) {
      console.error('Error registering with Eureka:', error);
    } else {
      console.log('Registered with Eureka');
    }
  });

  process.on('SIGINT', () => {
    client.stop(() => {
      process.exit();
    });
  });
};
