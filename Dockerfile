ARG VERSION
FROM docker.elastic.co/elasticsearch/elasticsearch:${VERSION}
USER root
# Nori 플러그인 설치
RUN bin/elasticsearch-plugin install analysis-nori
USER elasticsearch