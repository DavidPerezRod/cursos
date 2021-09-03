FROM ubuntu:18.04

RUN apt-get update
RUN apt-get install nginx -y
RUN apt-get install supervisor -y
RUN echo 'hello worldd' > /var/www/html/index.html

ADD ./supervisor/supervisor_services.conf /etc/supervisor/conf.d

EXPOSE 80

#CMD nginx -g 'daemon off;'
CMD supervisord -n -c /etc/supervisor/supervisord.conf

