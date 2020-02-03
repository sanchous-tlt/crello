const path = require('path');
const wpHtmlPlugin = require('html-webpack-plugin');

const config = {
  devServer: {
    historyApiFallback: true,
    port: '8000',
    proxy: {
      '/api': {
        pathRewrite: { '^/api': '' },
        target: 'http://localhost:8001',
      },
    },
  },
  entry: './src/index.jsx',
  module: {
    rules: [
      {
        exclude: /node_modules/,
        test: /\.ts$|\.js$|\.jsx$|\.tsx$/,
        use: {
          loader: 'ts-loader',
          options: {
            configFile: 'tsconfig.json',
          },
        },
      },
      {
        test: /\.css$/,
        use: [
          {
            loader: 'style-loader',
            options: {},
          },
          {
            loader: 'css-loader',
            options: {},
          },
        ],
      },
      {
        test: /\.(woff(2)?|ttf|eot|svg)$/,
        use: [
          {
            loader: 'file-loader',
            options: {
              name: '[hash].[ext]',
              outputPath: 'assets/fonts',
            },
          },
        ],
      },
    ],
  },
  output: {
    filename: 'assets/[hash].js',
    path: path.join(__dirname, 'dist'),
    publicPath: '',
  },
  plugins: [
    new wpHtmlPlugin({
      filename: 'index.html',
      inject: 'body',
      template: 'src/index.html',
    }),
  ],
  resolve: {
    extensions: ['.ts', '.js', '.jsx', '.tsx'],
  },
};

module.exports = config;
