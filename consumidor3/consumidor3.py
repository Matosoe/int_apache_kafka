from kafka import KafkaConsumer
import sys

consumer = KafkaConsumer('bolsafamilia2',
                         group_id='kafka-consumer-3',
                         bootstrap_servers=['localhost:9092'])

counter = 0;

# consumir mensagens disponíveis
KafkaConsumer(auto_offset_reset='earliest', enable_auto_commit=False)

sys.stdout.write('\rQuantidade de mensagens lidas: %d' % counter)

for message in consumer:
    counter = counter + 1
    sys.stdout.write('\rQuantidade de mensagens lidas: %d' % counter)
