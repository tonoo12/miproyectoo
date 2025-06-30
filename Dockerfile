FROM node:18-alpine

WORKDIR /app/shop

COPY shop/package*.json ./

RUN npm install

COPY shop ./

CMD ["node", "src/index.js"]
