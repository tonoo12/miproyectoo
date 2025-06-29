FROM node:18-alpine

WORKDIR /app

COPY shop/package*.json ./shop/
RUN npm install --prefix ./shop

COPY shop ./shop

CMD ["node", "shop/src/index.js"]
